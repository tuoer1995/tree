package com.ly.tree;

/**
 * 二叉查找树
 *
 * @author tuoer
 * @date 2019/3/10 17:54
 */
public class BinaryTree<T extends Comparable <? super T>> implements Tree <T> {
    private Node<T> tRoot;

    public BinaryTree( Node root ) {
        this.tRoot = root;
    }

    @Override
    public void insert( T val ) {
        insert ( tRoot , val );
    }

    private Node<T> insert( Node <T> root , T val ) {
        if ( root == null ) {
            return new Node <> ( val );
        }
        if ( val.compareTo ( root.val ) > 0 ) {
            root.right =insert ( root.right , val );
        } else {
             root.left = insert ( root.left , val );
        }
        return root;


    }

    @Override
    public Boolean find( T val ) {
        return find ( tRoot , val );
    }

    private Boolean find( Node <T> node , T val ) {
        if ( node == null ) {
            return false;
        }

        if ( val == null ) {
            return false;
        }

        if ( node.val.equals ( val ) ) {
            return true;
        } else if ( node.val.compareTo ( val ) > 0 ) {
            return find ( node.left , val );
        } else {
            return find ( node.right , val );
        }


    }

    @Override
    public Node<T> findMax( ) {
        return findMax (tRoot);
    }

    private Node<T> findMax( Node<T> root ) {
        if ( root == null ) {
            return null;
        }
        if ( root.right == null ) {
            return root;
        }

        return  findMax (root.right);

    }

    @Override
    public Node<T>  findMin( ) {
        return findMin (tRoot );
    }

    private Node<T> findMin( Node<T> root ) {
        if ( root == null ) {
            return null;
        }
        if ( root.left == null ) {
            return root;
        }

        return  findMin (root.left);
    }


    @Override
    public Node<T> remove( T val ) {
        return remove ( tRoot,val );
    }

    private Node<T> remove( Node<T> root , T val ) {
        if( root == null ) {
            return null;
        }

        final int compareResult = root.val.compareTo ( root.val );
        if ( compareResult > 0 ) {
            root.left = remove ( root.left,val );
        } else if(compareResult < 0) {
            root.right = remove ( root.right,val );
        } else if(root.right != null && root.left != null) {
            root.val  = (T) findMin ( root.right ).val;
            root.right = remove ( root.right,root.val );
        }  else {
            root = root.left != null ? root.right: root.left;
        }
        return root;
    }

    public void preSort(){
        preSort (tRoot);
    }

    private void preSort( Node<T> root ) {
        if(root == null) {
            return;
        }

        System.out.println (root);
        preSort ( root.left );
        preSort ( root.right);
    }

    public static void main( String[] args ) {
        BinaryTree binaryTree = new BinaryTree ( new Node ( 10 ) );
        binaryTree.insert ( 8 );
        binaryTree.insert ( 7 );
        binaryTree.insert ( 11 );
        binaryTree.insert ( 3);
        binaryTree.insert ( 5 );

        binaryTree.preSort ();
        System.out.println (binaryTree.findMax ());
        System.out.println (binaryTree.findMin ());
    }
}
