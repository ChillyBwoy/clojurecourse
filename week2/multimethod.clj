(def figs [{:type :rect :w 10 :h 20}
           {:type :rect :w 5  :h 6}
           {:type :circle :r 15}
           {:type :circle :r 2}
           {:type :triangle :a 5 :b 6 :c 7}
           {:type :hex :side 12}
           ])


(defn perimeter [fig]
  (case (:type fig)
    :circle (* 2 Math/PI (:r fig))
    :rect   (* 2 (+ (:w fig) (:h fig)))))

;; (map perimeter figs)

(defn dispatch [fig] (:type fig))

(defmulti p2 dispatch)

(defmethod p2 :default [fig]
  0)

(defmethod p2 :circle [fig]
  (* 2 Math/PI (:r fig)))

(defmethod p2 :rect [fig]
  (* 2 (+ (:w fig) (:h fig))))

(defmethod p2 :triangle [fig]
  (+ (:a fig) (:b fig) (:c fig)))

(map p2 figs)




(defmulti store (fn [db k v] (class db)))
(defmethod store com.redis.RedisDB [db k v]
  (.store db (str k) (str v)))


(def bot {:memory :file
          :iface :console
          :brain :default})

(defmulti remember (fn [bot k v] (:memory bot)))
(defmulti recall (fn [bot k] (:memory bot)))

(defmulti print-msg (fn [bot s] (:iface bot)))
(defmulti read-cmd (fn [bot] (:iface bot)))

(defmulti run-cmd (fn [bot cmd] (:brain bot)))
