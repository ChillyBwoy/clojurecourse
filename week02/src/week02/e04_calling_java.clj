(ns week02.e04-calling_java)

(import '[java.io File])


(File. "." "_calling_java.clj")
;; (java.io.File. "." "_calling_java.clj")

(.toUpperCase "abc")

(Math/sqrt 25)

Math/PI


(deftype Struct [a b c])
(def x (Struct. 1 2 3))
(.-a x)
(set! (.-a x) 5)


(doto (java.util.HashMap.)
  (.put "a" 1)
  (.put "b" 2))



;; (.start (Thread. #(println "abc")))

(let [th (Thread. #(println "abc"))]
  (.start th)
  th)


(doto (Thread. #(println "abc"))
  (.start))
