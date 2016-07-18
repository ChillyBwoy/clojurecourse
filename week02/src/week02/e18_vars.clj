(ns week02.e18-vars)

(def ^:dynamic *test-var* 20)

(defn add-to-var [num]
  (+ num *test-var*))

(defn print-var [txt]
  (println txt *test-var*))

(defn run-thread [x]
  (.run (fn []
          (print-var (str "Thread " x " before:"))
          (binding [*test-var* (rand-int 10000)]
            (print-var (str "Thread " x " after:"))))))

(doseq [x (range 3)] (run-thread x))
