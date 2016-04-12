{:foreign-libs [{:file "cljsjs/rangy/common/rangy-core.inc.js"
                 :provides ["cljsjs.rangy.core"]}

                {:file "cljsjs/rangy/common/rangy-textrange.inc.js"
                 :provides ["cljsjs.rangy.textrange"]
                 :requires ["cljsjs.rangy.core"]}
                {:file "cljsjs/rangy/common/rangy-classapplier.inc.js"
                 :provides ["cljsjs.rangy.classapplier"]
                 :requires ["cljsjs.rangy.core"]}

                {:file "cljsjs/rangy/common/rangy-highlighter.inc.js"
                 :provides ["cljsjs.rangy.highlighter"]
                 :requires ["cljsjs.rangy.core" "cljsjs.rangy.classapplier"]}

                {:file "cljsjs/rangy/common/rangy-selectionsaverestore.inc.js"
                 :provides ["cljsjs.rangy.selectionsaverestore"]
                 :requires ["cljsjs.rangy.core"]}
                {:file "cljsjs/rangy/common/rangy-serializer.inc.js"
                 :provides ["cljsjs.rangy.serializer"]
                 :requires ["cljsjs.rangy.core"]}
                ]
 :externs ["cljsjs/rangy/common/rangy.ext.js"]}
