(ns week2.e08-edn)
;; EDN – extensible data notation

(pr-str {:a 1})
(read-string "{:a 1}")


(spit "f.edn" {:a 1})
(read-string (slurp "f.edn"))



(require 'clojure.edn)
(clojure.edn/read-string (slurp "f.edn"))


;; #tag form
;; #inst "2012-01-31"

(let [t #inst "2012-01-31"]
  (class t))



