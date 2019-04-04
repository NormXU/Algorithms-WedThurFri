public class QuickSortLinkedList{

   	public ListNode quicksort(ListNode head){
   	   	if(head == null || head.next == null){
   	   	   	return head;
          }
          ListNode tail = null;
          return quick(head, tail);
    }

    private ListNode quick(ListNode start, ListNode end){
    	if(start == null || start.next == end || start == end){
    		return start;
      }
      ListNode[] result = part(start, end);
      ListNode leftSide = quick(result[0], result[1]);
      ListNode rightSide = quick(result[1].next, end);
      return leftSide;
    }

    private ListNode[] part(ListNode start, ListNode end){
    	if(start == null || start == end || start.next == end){
    		return new ListNode[] {start,end};
      }
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = start;
      for(ListNode j = start; j != null && j.next != null && j.next !=end; j = j.next){
    	   while(j.next != null && j.next.value <= start.value){
    		     ListNode tmp = j.next;
    		     j.next = j.next.next;
    		     tmp.next = dummyHead.next;
        		 dummyHead.next = tmp;
    	      }
        }

      return new ListNode[]{dummyHead.next, start};
    }
