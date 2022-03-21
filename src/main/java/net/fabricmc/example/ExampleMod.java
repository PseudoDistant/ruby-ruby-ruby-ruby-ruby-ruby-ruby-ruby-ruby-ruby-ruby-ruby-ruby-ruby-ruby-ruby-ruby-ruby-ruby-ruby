package net.fabricmc.example;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExampleMod extends RubyObject implements ModInitializer {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("require 'java'\n" +
            "\n" +
            "java_package 'net.fabricmc.example'\n" +
            "\n" +
            "java_import 'net.fabricmc.api.ModInitializer'\n" +
            "java_import 'org.apache.logging.log4j.LogManager'\n" +
            "java_import 'org.apache.logging.log4j.Logger'\n" +
            "\n" +
            "class ExampleMod java_implements ModInitializer\n" +
            "    LOGGER = LogManager.getLogger(\"modid\")\n" +
            "    java_signature 'void onInitialize()'\n" +
            "    def onInitialize()\n" +
            "        LOGGER.info(\"Hello Fabric World from Ruby!\")\n" +
            "    end\n" +
            "end\n" +
            "\n" +
            "").toString();
        __ruby__.executeScript(source, "ExampleMod.rb");
        RubyClass metaclass = __ruby__.getClass("ExampleMod");
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: ExampleMod");
        metaclass.setRubyStaticAllocator(ExampleMod.class);
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private ExampleMod(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaClass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new ExampleMod(ruby, metaClass);
    }

    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     */
    public ExampleMod() {
        this(__ruby__, __metaclass__);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }


    
    public void onInitialize() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "onInitialize");
        return;

    }

}
