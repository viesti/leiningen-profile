{:shared {:plugins [[cider/cider-nrepl "0.8.2"]
                    [lein-pprint "1.1.1"]]
          :repl-options {:init (set! *print-length* 42)}}
 :vinyasa {:dependencies [[im.chit/vinyasa "0.2.2"]
                          [im.chit/iroh "0.1.11"]
                          [org.clojure/tools.namespace "0.2.7"]]
           :injections [(require '[vinyasa.inject :as inject])
                        (inject/in [vinyasa.inject :refer [inject [in inject-in]]]
                                   [vinyasa.pull :all]
                                   [cemerick.pomegranate add-classpath get-classpath resources]
                                   [clojure.tools.namespace.repl refresh]
                                   clojure.core
                                   [iroh.core .> .? .* .% .%>]
                                   clojure.core >
                                   [clojure.pprint pprint]
                                   [clojure.java.shell sh]
                                   [clojure.repl doc source pst])]}
 :user [:shared :vinyasa]}
