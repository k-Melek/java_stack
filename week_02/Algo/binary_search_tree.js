class BSTNode {
  constructor(val) {
      this.val = val;
      /* These properties are how this node is connected to other nodes to form
      the tree. Similar to .next in a SinglyLinkedList except a BST node can
      be connected to two other nodes. To start, new nodes will not be
      connected to any other nodes, these properties will be set after
      the new node is instantiated.*/
      this.left = null;
      this.right = null;
  }
}

class BST {
  constructor() {
      /* Just like the head of a linked list, this is the start of our tree which
      branches downward from here. */
      this.root = null;
  }

  isEmpty() {
      return this.root === null;
  }

  // Iterative !
  getSmallestFromSubtree() {
    if(this.isEmpty()){
      return null;
    }
    var runner = this.root;
    // var min = 0;
    while(runner.left){
      runner = runner.left;
    }
    return runner.val;
  }

  // Recursive !
  getLargestFromSubtree(current) {

    // if current is undefined ! 
    if(current == undefined){
      current = this.root;
    }
    // if there are no further node , return null
    if(current === null) {
      return null;
    }
    if(current.right === null) {
      return current.val;
    }
    // Recursive call on the method !
    return this.getLargestFromSubtree(current.right);
  }
}