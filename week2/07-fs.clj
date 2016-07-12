(ns user)

(require '[clojure.java.io :as io])

(spit "file.txt" [:a 1])
(slurp "file.txt") ;; URLs, Reader, Socket


*in*
*out*
*err*


(with-open [wr (io/writer "file.txt")]
  (binding [*out* wr]
    (println "Hello, world!")
    (flush)))


(with-out-str
  (print "Hello, World!")
  (flush))


(slurp "file.txt")



(with-open [rd (io/reader "file.txt")]
  (vec
    (for [line (line-seq rd)]
      line)))
;; or
;; line-seq == lazy
(with-open [rd (io/reader "file.txt")]
  (vec (line-seq rd)))


(io/as-file "file.txt")
(file-seq (io/as-file "."))
(io/resource "log4j.properties")
