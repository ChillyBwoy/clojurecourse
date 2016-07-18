(ns week02.e15-refs)

(defn transfer-money [from to amount]
  (dosync
    (if (< @from amount)
      (throw (IllegalStateException.
               (str "Account has less money then required"
                    @from " < " amount)))
      (do (alter from - amount)
          (alter to + amount)))))


(defn add-to-deposit [to amount]
  (dosync
    (commute to + amount)))


(defn write-log [log-msg]
  (io!
    (println log-msg)))


(def ^:private acc-1 (ref 1000))
(def ^:private acc-2 (ref 1000))


(transfer-money acc-1 acc-2 500)
