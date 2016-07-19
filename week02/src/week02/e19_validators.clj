(ns week02.e19-validators)

(def a (atom 2))
(set-validator! a pos?)
(add-watch a "watch 1: "
           (fn [k r o n] (println k r o n)))
(add-watch a "watch 2: "
           (fn [k r o n] (println k r o n)))

(swap! a dec)
(swap! a dec)

(remove-watch a "watch 1: ")
(swap! a inc)

(def ^:dynamic b 1)
(add-watch (var b) "dynamic: "
           (fn [k r o n] (println k r o n)))
(alter-var-root (var b) (constantly 42))

(binding [b 10] (println b))
