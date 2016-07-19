(ns week02.e21-threads)


;; pmap

(defn long-job [n]
  (Thread/sleep 3000)
  (+ n 10))

(time (doall (map long-job (range 4))))
(time (doall (pmap long-job (range 4))))


(time (doall (pvalues
               (do (Thread/sleep 3000) 1)
               (do (Thread/sleep 3000) 2)
               (do (Thread/sleep 3000) 3))))


;; future

(def future-test
  (future (do (Thread/sleep 10000)
    :finished)))

@future-test


;; delays

(defn use-delay [x]
  {:result (delay (println "Evaluating result..." x) x)
   :some-info true})

(def a (use-delay 10))
@(:result a)



;; promises

(def p (promise))
(do (future
      (Thread/sleep 5000)
      (deliver p :fred))
  @p)


;; locking

(defn add-to-map [h k v]
  (locking h
    (.put h k v)))

(def h (java.util.HashMap.))
(add-to-map h "test" "value")
h


;; JVM

(.run (Thread. #(println "Hello, World!")))
