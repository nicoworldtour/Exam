package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Member
{
  String name;
  String email;
  List<Member> friends;
  
  public Member(String name, String email, List<Member> friends)
  {
    this.name = name;
    this.email = email;
    this.friends = friends;
  }
  
  public List<Member> getFriends()
  {
    return this.friends;
  }
  
  public String toString()
  {
    return this.name + ":" + this.email;
  }
  
  public static void main(String[] args)
  {
    Member a = createMember();
    printSocialGraph(a);
  }
  
  private static void printSocialGraph(Member member)
  {
    LinkedList<Member> queue = new LinkedList();
    queue.add(member);
    printrecursive(queue);
  }
  
  private static void printrecursive(LinkedList<Member> queue)
  {
    if (queue.size() > 0)
    {
      Member m = (Member)queue.pop();
      System.out.println(m);
      for (Member member : m.getFriends()) {
        queue.addLast(member);
      }
      printrecursive(queue);
    }
  }
  
  private static Member createMember()
  {
    ArrayList<Member> list1 = new ArrayList();
    ArrayList<Member> list2 = new ArrayList();
    ArrayList<Member> list3 = new ArrayList();
    ArrayList<Member> list4 = new ArrayList();
    
    Member c = new Member("totoc", "totoc@toto.fr", new ArrayList());
    Member d = new Member("totod", "totod@toto.fr", new ArrayList());
    
    Member g = new Member("totog", "totog@toto.fr", new ArrayList());
    list4.add(g);
    Member f = new Member("totof", "totof@toto.fr", list4);
    list3.add(f);
    Member e = new Member("totoe", "totoe@toto.fr", list3);
    
    list2.add(c);
    list2.add(d);
    list2.add(e);
    
    Member b = new Member("totob", "totob@toto.fr", list2);
    
    list1.add(b);
    
    Member a = new Member("totoa", "totoa@toto.fr", list1);
    
    return a;
  }
}
