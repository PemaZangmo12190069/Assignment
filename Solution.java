import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;
    private int size; 
    static int count;            // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.size = size;
            left = null;
            right = null;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root = null;
        size = 0;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
       if (size == 0) {
            return true;
        }
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
       
    }

    // return number of key-value pairs in BST rooted at x
    // private int size(Node x) {
        
       
    // }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        Node x = root;
        if (key == null) {
            throw new IllegalArgumentException ("Argument is null!!!");
        }
        if (x == null) {
            return null;
        }
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            }
            else if(cmp > 0) {
                x = x.right;
            }
            else {
                return x.val;
            }
        }
        return x.val;
        
    }

    // private Value get(Node x, Key key) {
       
        
        
    // }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        Node x = root;
        Node parent;
        Node newest = new Node(key, val);
        if (key == null) {
            throw new IllegalArgumentException("Argument is null!!!");
        }
        if (x == null) {
            root = newest; 
        }
        while (x != null){
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
                if (x == null) {
                    parent.left = newest;
                    size = size+1;
                    return;   
                }
                else if (x.key == key) {
                    x.val = val;
                    return;   
                } 
            }
            else if (cmp > 0) {
                x = x.right;
                if (x == null) {
                    parent.right = newest;
                    size = size+1;
                    return;
                }
                else if (x.key == key) {
                    x.val = val;
                    return;
                }  
            }  
        }
        size = size + 1;
       
    }

    // private Node put(Node x, Key key, Value val) {
        
    // }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       Node x = root;
       if (x == null) {
           throw new NoSuchElementException ("No element!!!");
       }
       while (x.left != null) {
            x = x.left;

       }
       return x.key;
    } 

    // private Node min(Node x) { 
         
    // } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        Node cmp = x;
        if (key == null) {
            throw new IllegalArgumentException("Argument is Null"); 
        }   
        else if (size() == 0) {
            throw new NoSuchElementException("No element!!!");
        }
        if (x==null) {
            return null;
        } 
        if(x.left!=null){
            cmp = x.left;
            
            while(cmp.right!=null){
                cmp = cmp.right;
            }
        }
        return cmp.key;
        // Node x = root;
        // Node z = null;
        // if (key == null) {
        //     throw new IllegalArgumentException ("Argument is null!!!");
        // }
        // if (x == null) {
        //     throw new NoSuchElementException (" No element!!!");
        // }
        // while (x != null) {
        //     int cmp = key.compareTo(x.key);
        //     if (cmp == 0) {
        //         return x.key;
        //     }
        //     else if (cmp < 0) {
        //         x = x.left;
        //         // int temp;
        //         // //temp = cmp;
        //         // temp = key.compareTo(x.key);
        //         // // if (temp == cmp) {
        //         // //     x = x.left;
        //         // //     return x.key;
        //         // // }
        //         // if (temp < 0) {
        //         //     x = x.left;
        //         //     return x.key;
        //         // }
        //         // else if (temp > 0) {
        //         //     x = x.right;
        //         //     return x.key;
        //         // }
        //     }
        //     else if (cmp > 0) {
        //         z = x;
        //         x = x.right;
        //         // int temp;
        //         //temp = cmp;
        //         // temp = key.compareTo(x.key);
        //         // // if (temp == cmp) {
        //         // //     x = x.left;
        //         // //     return x.key;
        //         // // }
        //         // if (temp < 0) {
        //         //     x = x.left;
        //         //     return x.key;
        //         // }
        //         // else if (temp > 0) {
        //         //     x = x.right;
        //         //     return x.key;
        //         // }
        //     }
        // }
        // return x.key;
    } 

    private Node floor(Node x, Key key) {
        Node node = null;
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");   
        }
        while( x!= null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp > 0) {
                node = x;
                x = x.right;
            }
            else {
                x = x.left;
            }
        }
        return node;
       
    } 

    
    

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        count = 0;
        if (k < 0 || k >= size) {
            throw new IllegalArgumentException ("Invalid Argument!!!");
        }
        return select(root, k+1).key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        // ArrayList<Node> arr = new ArrayList<Node>();
        // Node y = root;
        // while (!arr.isEmpty() || y != null) {
        //     if (y != null) {
        //         arr.add(y);
        //         y = y.left;
        //     }
        //     else {
        //         y = arr.remove();
        //         count++;
        //         if (count == k) {
        //             break;
        //         y = y.right;
        //         }
        //     }
        //     return y;
        // }
        Stack<Node> stack= new Stack<Node>();
        Node y = root;
        while (!stack.empty() || y != null) {
            if (y != null) {
                stack.push(y);
                y = y.left;
            }
            else {
                y = stack.pop();
                count++;
                if (count == k)
                    break;
                y = y.right;
            }
        }
        return y;
         
    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) {
            throw new IllegalArgumentException("Argument is null!!!");
        }
        ArrayList<Key> arr = new ArrayList<Key>();
        keys(root, arr, lo, hi);
        return arr;
    }

    private void keys(Node x,ArrayList<Key> arr, Key lo, Key hi) { 
        if (x == null) {
            return;
        }
        Node node1 = x;
        while (node1 != null){
            int cmp = node1.key.compareTo(hi);
            int cmp1 = node1.key.compareTo(lo);

            if (node1.left == null) {
                if (cmp <= 0 && cmp1 >= 0) arr.add(node1.key);
                node1 = node1.right;
            }
            else {
                Node node2 = node1.left;
                while (node2.right != null && node2.right != node1)
                    node2= node2.right;
                if (node2.right == null) {
                    node2.right = node1;
                    node1 = node1.left;
                }
                else {
                    node2.right = null;
                    if (cmp <= 0 && cmp1>=0) arr.add(node1.key);
                    node1 = node1.right;
                }
            }
        }
    }
}