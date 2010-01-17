(defn sing
  ([] (sing 99))
  ([n]
     (let [r1 (range n 0 -1)
	   otw " on the wall.\n\t"
	   bob #(str %1 " bottle" (if (= 1 %1) "" "s") " of beer" %2)
	   tod #(str "Take " %1 " down, pass it around;\n\t" (bob %2 otw) "\n")
	   r2 (range (dec n) 0 -1)]
       (apply str
	      (concat
	       (doall
		(interleave
		 (map #(bob % otw) r1)
		 (map #(bob % ".\n") r1)
		 (map #(tod "one" %) r2)))
	       (list (bob 1 otw)(bob 1 ".\n")(tod "it" "No more")))))))



(comment
  (let [
	   beers-wall (repeatedly #(str bottle "s " beer " " wall ". "))
	   before (repeatedly #(str bottle "s " beer ".\n"))
	   act (repeatedly #(str take " one " down))
	   after (repeatedly #(str bottle "s " beer " " wall ".\n"))]
	 (print (apply str (interleave r1 beers-wall r1 before act r2 after))
		(str "1 " bottle " " beer " " wall ", "
		     "1 " bottle " " beer".\n"
		     take " it " down " "
		     "No more " bottle "s " beer " " wall "!\n"))))
