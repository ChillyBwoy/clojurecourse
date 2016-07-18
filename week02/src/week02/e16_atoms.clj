(ns week02.e16-atoms)


(def ^:private counters (atom {}))

(defn inc-counter [name]
  (swap! counters update-in [name]
         (fnil inc 0)))

(defn dec-counter [name]
  (swap! counters update-in [name]
         (fnil dec 0)))

(defn reset-counter [name]
  (swap! counters assoc name 0))


(inc-counter :test)
(inc-counter :another-counter)
(reset-counter :test)
