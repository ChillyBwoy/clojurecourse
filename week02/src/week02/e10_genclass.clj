(ns week02.e10-genclass
  (:gen-class
   :name user.SomeClass
   :prefix cl-
   :extend ...
   :implements [...]
   :state state
   :init init
   :constructors {[String] []}
  ))


(defn some-fn [])

(defn -init [s]
  [[] ;; super construct
   (atom (.toUpperCase s)) ;; state
   ])


(defn -main [& args]
  (println args))


(defn -method1 [this abc]
  (.-state this)
  (println abc))


(defn -method2 [this]
  (println "ff"))

(defn ^:static -method3 []
  (println "fff"))


(.method1 (user.SomeClass.) "xxx")
