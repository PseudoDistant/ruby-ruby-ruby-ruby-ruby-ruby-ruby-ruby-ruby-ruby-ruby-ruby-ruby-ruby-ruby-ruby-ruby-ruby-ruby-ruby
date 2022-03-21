require 'java'

java_package 'net.fabricmc.example'

java_import 'net.fabricmc.api.ModInitializer'
java_import 'org.apache.logging.log4j.LogManager'
java_import 'org.apache.logging.log4j.Logger'

class ExampleMod java_implements ModInitializer
    LOGGER = LogManager.getLogger("modid")
    java_signature 'void onInitialize()'
    def onInitialize
        LOGGER.info("Hello Fabric World from Ruby!")
    end
end

