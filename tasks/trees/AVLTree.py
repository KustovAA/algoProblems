from typing import Optional
from tasks.trees.Node import Node, height
from tasks.trees.BinarySearchTree import BinarySearchTree
import traceback, sys


class AVLTree(BinarySearchTree):
    def insert(self, val: int):
        inserted_node = super().insert(val)
        self.root = AVLTree.rebalance(self.root)

        return inserted_node

    def remove(self, val: int):
        try:
            super().remove(val)
            self.root = AVLTree.rebalance(self.root)
        except Exception:
            traceback.print_exc()
            return

    @staticmethod
    def rebalance(node: Optional[Node]):
        if node.left:
            node.left = AVLTree.rebalance(node.left)

        if node.right:
            node.right = AVLTree.rebalance(node.right)

        return AVLTree.rebalance_node(node)

    @staticmethod
    def rebalance_node(node: Optional[Node]):
        if node is None:
            return None

        if node.balance() > 1:
            if node.left.balance() >= 0:
                return AVLTree.small_right_rotation(node)

            else:
                return AVLTree.big_right_rotation(node)

        if node.balance() < -1:
            if node.right.balance() <= 0:
                return AVLTree.small_left_rotation(node)

            else:
                return AVLTree.big_left_rotation(node)

        return node

    @staticmethod
    def small_left_rotation(node: Node) -> Optional[Node]:
        new_root = node.right
        new_root.parent = node.parent
        node.right = new_root.left
        if new_root.left:
            new_root.left.parent = node.right
        new_root.left = node
        node.parent = new_root
        return new_root

    @staticmethod
    def small_right_rotation(node: Node) -> Optional[Node]:
        new_root = node.left
        new_root.parent = node.parent
        node.left = new_root.right
        if new_root.right:
            new_root.right.parent = node.left
        new_root.right = node
        node.parent = new_root
        return new_root

    @staticmethod
    def big_left_rotation(node: Node) -> Optional[Node]:
        node.right = AVLTree.small_right_rotation(node.right)
        return AVLTree.small_left_rotation(node)

    @staticmethod
    def big_right_rotation(node: Optional[Node]) -> Optional[Node]:
        node.left = AVLTree.small_left_rotation(node.left)
        return AVLTree.small_right_rotation(node)
