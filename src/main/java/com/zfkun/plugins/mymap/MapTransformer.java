package com.zfkun.plugins.mymap;

import com.janetfilter.core.models.FilterRule;
import com.janetfilter.core.plugin.MyTransformer;

import java.util.List;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import jdk.internal.org.objectweb.asm.tree.VarInsnNode;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class MapTransformer implements MyTransformer {
    private final List<FilterRule> rules;

    public MapTransformer(List<FilterRule> rules) {
        this.rules = rules;
    }

    public String getHookClassName() {
        return "com/google/gson/internal/LinkedTreeMap";
    }

    public byte[] transform(String className, byte[] classBytes, int order) throws Exception {
        PutFilter.setRules(this.rules);

        ClassReader reader = new ClassReader(classBytes);
        ClassNode node = new ClassNode(ASM5);
        reader.accept(node, 0);

        for (MethodNode methodNode : node.methods) {
            if (methodNode.name.equals("put") && methodNode.desc.equals("(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;")) {
                InsnList list = new InsnList();
                list.add(new VarInsnNode(ALOAD, 1));
                list.add(new VarInsnNode(ALOAD, 2));
                list.add(new MethodInsnNode(INVOKESTATIC, "com/zfkun/plugins/mymap/PutFilter", "testPut", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", false));
                list.add(new VarInsnNode(ASTORE, 2));
                methodNode.instructions.insert(list);
            }
        }

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        node.accept(writer);

        return writer.toByteArray();
    }
}
