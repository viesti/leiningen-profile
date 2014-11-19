{:shared {:plugins [[cider/cider-nrepl "0.8.0-SNAPSHOT"]]
          :repl-options {:init (set! *print-length* 42)
                         :nrepl-middleware
                         [cider.nrepl.middleware.classpath/wrap-classpath
                          cider.nrepl.middleware.complete/wrap-complete
                          cider.nrepl.middleware.info/wrap-info
                          cider.nrepl.middleware.inspect/wrap-inspect
                          cider.nrepl.middleware.macroexpand/wrap-macroexpand
                          cider.nrepl.middleware.resource/wrap-resource
                          cider.nrepl.middleware.stacktrace/wrap-stacktrace
                          cider.nrepl.middleware.test/wrap-test
                          cider.nrepl.middleware.trace/wrap-trace
                          cider.nrepl.middleware.undef/wrap-undef]}}
 :vinyasa {:dependencies [[im.chit/vinyasa "0.2.2"]
                          [im.chit/iroh "0.1.11"]]
           :injections [(require '[vinyasa.inject :as inject])
                        (inject/in
                         [vinyasa.inject :refer [inject [in inject-in]]]
                         [vinyasa.pull :all]
                         [cemerick.pomegranate add-classpath get-classpath resources]
                         clojure.core
                         [iroh.core .> .? .* .% .%>]
                         clojure.core >
                         [clojure.pprint pprint]
                         [clojure.java.shell sh])]}
 :user [:shared :vinyasa]}
