(ns week2.e09-metadata)


(def m {:s 2})
(meta m)
(meta (with-meta m {:doc "hai!"}))


(def ^:const x 0)
(:const (meta #'x))


(defn- f
  "docstring"
  (^String [^Long x y z])
  (^Long [z]))

(:doc (meta #'f))
(:private (meta #'f))
(meta (first (first (:arglists (meta #'f)))))
