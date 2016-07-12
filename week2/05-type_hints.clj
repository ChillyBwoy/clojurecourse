(ns user)
(set! *warn-on-reflection* true)

(defn strlen ^Integer [^String s]
  (.length s))

(.intValue (strlen "123"))


(def ^String x "abc")
(StringBuilder. x)



(defrecord R [^long a
              ^byte b])
