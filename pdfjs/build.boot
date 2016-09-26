(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer [download]])

(def +lib-version+ "1.5.417")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/pdfjs
       :version +version+
       :description "PDF Reader in JavaScript"
       :url         "https://github.com/mozilla/pdf.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url "http://localhost:8888/build/pdf.js")
    (download :url "http://localhost:8888/build/pdf.worker.js")
    (download :url "http://localhost:8888/build/components/pdf_viewer.js")
    (sift :move {#"^pdf\.js$"         "cljsjs/pdfjs/common/pdf.js"
                 #"^pdf\.worker\.js$" "cljsjs/pdfjs/common/pdf.worker.js"
                 #"^pdf_viewer\.js$"  "cljsjs/pdfjs/common/pdf_viewer.js"})
    (sift :include #{#"^cljsjs/" #"^deps\.cljs$"})))
