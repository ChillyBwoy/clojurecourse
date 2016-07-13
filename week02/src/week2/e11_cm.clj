(ns week2.e11-cm
  (:use [clojure.core.match :only (match)]))


(def req (vec (.split "select students where id > 10" " ")))


(defn check-match [check]
  (match check
         ["select" tbl & _] (do (println "Table is:" tbl)
                                (check-match (vec (drop 2 check))))
         ["where" a b c] (println "Conditions:" a b c)
         :else (println "No match found")))


(check-match req)
