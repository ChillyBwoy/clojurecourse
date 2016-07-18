(ns week02.e17-agents)

(def ^:private counters (agent {}))

(defn inc-counter [name]
  (send counters update-in [name]
         (fnil inc 0)))

(defn dec-counter [name]
  (send counters update-in [name]
         (fnil dec 0)))

(defn reset-counter [name]
  (send counters assoc name 0))


(inc-counter :test)
(inc-counter :another-counter)
(reset-counter :test)
