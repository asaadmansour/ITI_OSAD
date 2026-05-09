/**
 * AVL TREES "Self Balancing Trees"
 * Balance Factor = Height of left subtree - height of right subtree {-1,0,1}
 * bf = |hl-hr| <= 1 balanced
 * bf = |hl-hr| > 1 inbalanced
 * we check every node to see if it's balanced if not we do "rotations" to balanace that tree
 * usually inbalance factor does not exceed 2
 * after insertion may one of these happen
 * LL - left of the left is inbalanced like 30 - 20 and we wanna insert 10 so it will be in balanced bec of the left left
 * can be called right rotation or clock wise rotation
 * RR - is the complete opposite of the LL
 * LL - RR Are single rotations
 * LR - we do 2 steps one to make it as LL and then the rotation to make it balanced
 * RL - the opposite of LR
 * LR - RL Are double rotations
 * we know the type of rotation after moving 2 steps from root and do the rotation on those
 *
 *
 **/
class LectureOne {
    public static void main(String[] args) {

    }
}