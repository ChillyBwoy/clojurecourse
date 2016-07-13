(ns week2.e06-reify-and-proxy)

(import '[java.util ArrayList Collections Comparator Timer TimerTask])

(.start (Thread. #(println "abc")))


(let [arr (ArrayList. [3 2 4 1])
      dir -1
      comp (reify Comparator
             (compare [this a b]
                      (* dir (- b a))))]
  (Collections/sort arr comp)
  arr)



(let [task (proxy [TimerTask] []
             (run []
                  (println (rand))))]
  (.schedule (Timer.) task 1000))
