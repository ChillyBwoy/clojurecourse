;; ------------ funcs
(apply + 1 2 3 4 [1 2 3 4])

;; ---String---
(class "abc")
(.length "abc")
(count "abc")
(.indexOf "abc" "b")

(str 1 "-" :x "-" nil)
(format "Num %07d str %s" 42 "---")

(subs "abcdef" 2 4)

(require '[clojure.string :as str])

(str/join "," [1 2 3 4 5])
(str/split "1, 2, 3, " #",\s+")
(str/upper-case "dog cat")

(re-find #"a+" "aaaaaaaabbbbbaaaaccc")
(re-matches #"a+" "aaaaaaaabbbbbaaaaccc")
(re-seq #"a+([^a])" "aaaaaaaabbbbbaaaaccc")

(str/replace "dog cat mouse" "cat" "horse")
(str/replace "dog cat mouse" #"[act]+" #(apply str (reverse %)))

;; -----------------
;; ---Collections---

;; List
(def l (list 1 2 3 4))
(conj l 5 6)
(nth l 2 :default)

;; Vector
(def v [1 2 3 4])
(conj v 5 6)
(nth v 2)
(get v 2 :default)

;; Map
(def m {:x 1 :y 2})
(sorted-map "y" 1 "x" 2)
(get m :x :default)

(assoc m :z 3)
(dissoc m :x)
(contains? m :z)

;; Set
(def s #{1 2 3})
(conj s 2)
(contains? s 2)
(get s :x)

(clojure.set/difference #{1 2 3} #{3 4 5})

;; Equality
(= [1 2 3] '(1 2 3))
(= #{[1 2]} #{'(1 2)})


;; ---Collections---
(def xs [1 2 3 4 5])

(map dec xs)
(filter odd? xs)
(remove odd? xs)

(take 10
      (remove odd?
              (map dec
                   (filter odd?
                           (map inc
                                (range 1000))))))

(reduce conj '() xs)

(for [v [[1 2] [3 4]]
      x v
      :let [y (+ 1 x)]
      :when (even? y)
      :while (< y 4)]
  (inc x))


(doseq [x [1 2 3]]
  (println x))




;; -------
(map {:x 1} [:x :y :z])
(filter #{1 2 3} [3 4 5 6])


(def v [:a :b :c])
(get v 1)

(v 1)

(def m {1 "one"
        2 "two"
        3 "three"})
(get m 10 "?")
(m 10 "?")

(map m [1 2 3 4 3 1])

(def s #{"piss" "fuck"})
(get s "abc")
(get s "piss")
(s "piss")

(remove s ["abc" "dog" "piss" "cat"])

(get {:k1 1 :k2 2} :k1 7)
(:k3 {:k1 1 :k2 2} 7)


(def users [{:name "Ilya"
             :age 32}
            {:name "Vasya"
             :age 17}
            {:name "Oleg"
             :age 11}])

(map :name users)
(apply min (map :age users))



;; ------ Exceptions ------
(try
  (throw (ex-info "123" {:x 1 :y 2}))
  (catch clojure.lang.ExceptionInfo e
    (ex-data e))
  (catch java.lang.Exception e
    (.printStackTrace e)
    8)
  (finally
    (println "Safe now")))


;; ------ Threading macros -----------

(as-> 17 x
      (+ x 1)
      (- 100 x)
      (str x))


(as-> [1 2 3 4 5 6] xs
      (map inc xs)
      (filter even? xs)
      (remove #(> % 5) xs)
      (vec xs)
      (str xs))


(->> [1 2 3 4 5 6 7]
     (map inc)
     (filter even?)
     (remove #(> % 5))
     (vec)
     (str))

(-> 1
    (+ 1)
    (- 2)
    (str 3))


(some-> {:a {:b {:c 1}}} :a :x :c (+ 1))


;; ------ Destruction -----------
(defn f [x]
  [:ok [(* 2 x) (/ x 2)] (pos? x)])

(let [[_ [v1 v2] pos?] (f -1)]
  [v1 v2])


(def m {:name "Vanya" :age 17})

(let [{n :name
       a :age
       :as full
       :or {a 10}} m]
  [n a full])


(let [{:keys [name age]} m]
  [name age])


(defn f [_ & {:as opts}]
  opts)

(f 1 :flag true
     :debug false
     :indent 11)



;; --- Bindings ---
(def ^:dynamic *log* false)

(binding [*log* 77]
  *log*)

*log*


(def ^:dynamic *pprint* false)
(def ^:dynamic *escape-unicode* false)

(defn write-json [obj & {:as opts}]
  (binding [*pprint* (:pprint opts false)]
    (str obj)))

(write-json [1 2 3])