(def repeat-song false)
(def n2Nmap {1 "One" 2 "Two" 3 "Three" 4 "Four" 5 "Five" 6 "Six" 7 "Seven" 8 "Eight" 9 "Nine" 10 "Ten" 11 "Eleven" 12 "Twelve" 13 "Thirteen" 14 "Fourteen" 15 "Fifteen" 16 "Sixteen" 17 "Seventeen" 18 "Eighteen" 19 "Nineteen" 20 "Twenty" 30 "Thirty" 40 "Fourty" 50 "Fifty" 60 "Sixty" 70 "Seventy" 80 "Eighty" 90 "Ninety"})
(defn n2N [n] (if (or (> 21 n) (= 0 (rem n 10)))
		(n2Nmap n) 
		(str (n2Nmap (* 10 (quot n 10))) "-" (n2Nmap (rem n 10)))))
(defn Bottles [n] (str (n2N n) " bottle" (if (= 1 n) "" "s"))) 
;(defn bottles [n] (.toLowerCase (Bottles n))) ; FYI, unused
(defn nbobotw [n punc]
  (str n " of beer on the wall" punc))
(defn nbob [n]
  (str n " of beer!"))
(defn txdpia [one-or-it]
  (str "Take " one-or-it " down,\n Pass it around,\n "))
(defmulti verse (fn [n][(= 0 n)(= 1 n)]))
(defmethod verse [false false] [n] ; >1
  (let [m (dec n)]
  (do
    (println (nbobotw (Bottles n) ",\n")(nbob (Bottles n)))
    (println (txdpia "one")
	     (nbobotw (if (= 0 m) "no more bottles" (Bottles m)) "!\n"))
    (verse m))))
(defmethod verse [false true] [n] ; =1
  (do
    (println (nbobotw (Bottles 1) ",\n")(nbob (Bottles 1)))
    (println (txdpia "it")
	     (nbobotw "No more bottles" "!\n"))
    (verse 0)))
(defmethod verse [true false] [n] ; =0
  (do
    (println (nbobotw "No more bottles" ",\n")(nbob "No more bottles"))
    (println "Go to the store and buy some more,\n" 
	     (nbobotw "Nintey-nine bottles" "!\n"))
    (if repeat-song (verse 99)))); until too much beer--stack overflow :-)
(defn sing
  ([] (verse 99))
  ([n] (verse n)))



