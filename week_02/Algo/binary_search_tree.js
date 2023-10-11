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

  // test empty
  isEmpty() {
    return this.root === null;
  }
  // Iterative !
  getSmallestFromSubtree() {
    if (this.isEmpty()) {
      return null;
    }
    var runner = this.root;
    // var min = 0;
    while (runner.left) {
      runner = runner.left;
    }
    return runner.val;
  }

  // Recursive !
  getLargestFromSubtree(current) {
    // if current is undefined !
    if (current == undefined) {
      current = this.root;
    }
    // if there are no further node , return null
    if (current === null) {
      return null;
    }
    if (current.right === null) {
      return current.val;
    }
    // Recursive call on the method !
    return this.getLargestFromSubtree(current.right);
  }

  find(target, current) {
    // if current is undefined !
    if (current === undefined) {
      current = this.root;
    }

    //if current is null, return false up the call back
    if (current === null) {
      return false;
    }

    if (current.val === target) {
      return true;
    }

    const lookInLeft = this.find(target, current.left);
    const lookInRight = this.find(target, current.right);

    const result = lookInLeft || lookInRight;

    return result;
  }

  // insertion

  insert(node, current) {
    // if current is undefined !
    if (current === undefined) {
      current = this.root;
    }
    //if current is null, return false up the call back
    if (current === null) {
      this.root = node;
      return;
    }

    if (current.val > node.val) {
      if (current.left === null) {
        current.left = node;
        return;
      } else {
        return this.insert(node, current.left);
      }
    } else if (current.val < node.val) {
      if (current.right === null) {
        current.right = node;
        return;
      } else {
        return this.insert(node, current.right);
      }
    }
  }
}

const bst = new BST();
// bst.insert(new BSTNode(5));

bst.insert(new BSTNode(25));
bst.insert(new BSTNode(15));
bst.insert(new BSTNode(50));
bst.insert(new BSTNode(10));
bst.insert(new BSTNode(22));
bst.insert(new BSTNode(35));
bst.insert(new BSTNode(70));
bst.insert(new BSTNode(12));
bst.insert(new BSTNode(48));

console.log(bst);
// console.log(bst.find(18));
// console.log(bst.find(20));
