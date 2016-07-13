(ns week2.e05-type-hints)

(set! *warn-on-reflection* true)

(defn strlen ^Integer [^String s]
  (.length s))

(.intValue (strlen "123"))


(def ^String x "abc")
(StringBuilder. x)



(defrecord R [^long a
              ^byte b])
