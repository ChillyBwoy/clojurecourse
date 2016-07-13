(use 'csvdb.core :reload)

(table-keys student-tbl)
(key-value-pairs [:id :surname :year :group_id] ["1" "Ivanov" "1996"])
(data-record [:id :surname :year :group_id] ["1" "Ivanov" "1996"])
(data-table student-tbl)
(str-field-to-int :id {:surname "Ivanov", :year "1996", :id "1"})


(where* student (fn [rec] (> (:id rec) 1)))
(limit* student 2)
(order-by* student :year)
(join*
  (join* student-subject :student_id
         student :id) :subject_id
  subject :id)

(reduce (fn [acc item]
          (conj acc (* item item))) [] [1 2 3 4 5])
