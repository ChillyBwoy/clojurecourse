(ns week02.e20_deftype)


;; transient

(defn vrange [n]
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))


(defn vrange2 [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))


(time (def v1 (vrange 1000000)))
(time (def v2 (vrange2 1000000)))


;; deftype

(defprotocol TestProtocol
  (get-data [this])
  (set-data [this o]))

(deftype Test [^:unsynchronized-mutable x-var]
  TestProtocol
  (set-data [this o] (set! x-var o))
  (get-data [this] x-var))

(def a (Test. 10))
(get-data a)

(set-data a 42)
(get-data a)


;; with-local-vars

(defn factorial [x]
  (with-local-vars [acc 1 cnt x]
    (while (> @cnt 0)
      (var-set acc (* @acc @cnt))
      (var-set cnt (dec @cnt)))
    @acc))


(factorial 6)
