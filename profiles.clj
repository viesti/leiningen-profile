{:shared {:plugins [[cider/cider-nrepl "0.9.1"]
                    [lein-pprint "1.1.1"]
                    [jonase/eastwood "0.2.1"]
                    [lein-ancient "0.6.7"]
                    [org.clojure/tools.nrepl "0.2.10"]
                    [com.jakemccrary/lein-test-refresh "0.10.0"]]
          :global-vars {*print-length* 100}
          :figwheel {:open-file-command "figwheel-file-opener"}
          :test-refresh {:growl true}}
 :vinyasa {:dependencies [[im.chit/vinyasa "0.2.2"]
                          [im.chit/iroh "0.1.11"]
                          [org.clojure/tools.namespace "0.2.11"]
                          [aprint "0.1.3"]
                          [spyscope "0.1.5"]]
           :injections [(require '[vinyasa.inject :as inject]
                                 'spyscope.core)
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
 :droid {:plugins [[lein-droid "0.4.0-alpha4"]]}
 :moar-opts {:jvm-opts ["-XX:+UnlockDiagnosticVMOptions" "-XX:+DebugNonSafepoints" "-XX:+UnlockCommercialFeatures" "-XX:+FlightRecorder"]}
 :yagni {:plugins [[venantius/yagni "0.1.2"]]}
 :refactor {:plugins [[refactor-nrepl "1.1.0"]]}
 :user [:shared :vinyasa :moar-opts :refactor]}

