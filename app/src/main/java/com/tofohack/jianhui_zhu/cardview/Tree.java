package com.tofohack.jianhui_zhu.cardview;

/**
 * Created by jianhuizhu on 15-08-27.
 */
public class Tree {
    private String name;
    private int imagePath;

    private Tree(TreeBuilder treeBuilder) {
        setName(treeBuilder.name);
        setImagePath(treeBuilder.imagePath);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public static class TreeBuilder {
        private String name;
        private int imagePath;

        public TreeBuilder() {
        }

        public TreeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TreeBuilder setImagePath(int imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Tree build() {
            return new Tree(this);
        }
    }

}
