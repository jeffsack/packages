{:foreign-libs [{:file "cljsjs/pdfjs/common/pdf.js"
                 :provides ["cljsjs.pdfjs"]} 
                {:file "cljsjs/pdfjs/common/pdf_viewer.js" 
                 :provides ["cljsjs.pdfjs.viewer"]
                 :requires ["cljsjs.pdfjs"]}]
 :externs ["cljsjs/pdfjs/common/pdf.ext.js"]}
