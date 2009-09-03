(defmacro bottles [n#]
  `(str ~n# " bottle" (if (= 1 ~n#)
		      ""
		      "s")))
(defn sing
  ([] (sing 99)) ; default
  ([stock] (loop [n stock next ""]
	     (if (= 0 n)
	       (do (println " bottles of beer on the wall.")
		   "Buy some more!")
	       (do
		 (print (str next (bottles n) " of beer on the wall, " 
			     (bottles n) " of beer.\n Take one down and pass it around, " 
			     (dec n)))
		 (recur (dec n) (str " bottles of beer on the wall.\n\n" )))))))