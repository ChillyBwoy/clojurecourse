;; (def p {:x 1 :y 2})
;; (:x p)
(ns records)
(deftype PointT [^long x
                 ^:long y])
(def p (PointT. 10 10))
(.-x p)



;; предпочтительный clojure-way
(defrecord PointR [^long x ^long y])
(def p (PointR. 10 10))

(:x p)
(get p :x)

(assoc p :x 20)
(:z (assoc p :z 10))
(= (PointT. 10 10) (PointT. 10 10))
(= (PointR. 10 10) (PointR. 10 10))


(defprotocol IFormat
  (format [this]))


(defrecord Cal [d m y]
  IFormat
  (format [_] (str d "." m "." y))

  java.lang.Comparable
  (compareTo [_ o2]
    (compare
      [y m d]
      [(.-y o2) (.-m o2) (.-d o2)])))


(format (Cal. 14 2 2016))
(compare (Cal. 12 2 2016) (Cal. 14 2 2016))
