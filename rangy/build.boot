(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer [download]])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/rangy
       :version +version+
       :description "A cross-browser JavaScript range and selection library."
       :url         "https://github.com/timdown/rangy"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"The MIT License (MIT)" "http://www.opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/timdown/rangy/releases/download/%s/rangy-%s.zip" +lib-version+ +lib-version+)
              :checksum "D65D550837795D741B88FBC69887DF12"
              :unzip true)
    (sift :move {#"^rangy-core.js$" "cljsjs/rangy/common/rangy-core.inc.js"
                 (re-pattern (format "rangy-%s/uncompressed/rangy-(.*)\\.js" +lib-version+)) "cljsjs/rangy/common/rangy-$1.inc.js"})
    (sift :include #{#"^cljsjs/" #"^deps\.cljs$"})))
