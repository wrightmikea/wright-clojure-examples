(defn bottles [n] (str n " bottle" (if (= 1 n) "" "s"))) ; convert 2->two, etc.?
(defn nbobotw [s p]
  (str s " of beer on the wall" p))
(defn nbob [s]
  (str s " of beer."))
(defmulti verse (fn [n][(= 0 n)]))
(defmethod verse [false] [n] 
  (let [m (dec n)]
  (do
    (println (nbobotw (bottles n) ",")(nbob (bottles n)))
    (println (str "Take one down and pass it around, "
		  (nbobotw (if (= 0 m) "no more bottles" (bottles m)) ".\n")))
    (verse m))))
(defmethod verse [true] [n] 
  (do
    (println (nbobotw "No more bottles" ",")(nbob "no more bottles"))
    (println "Go to the store and buy some more," (nbobotw "99 bottles" ".\n"))
    (verse 99))); intentionally ends with stack overflow :-)
(defn sing
  ([] (verse 99))
  ([n] (verse n)))


