package ThreadUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * bug
 * �߳����ݹ���˵���˾��ǹ���ɱ�״̬
 * getPlayer()
 * @author JossC
 *
 */
public class Tournament {
	private List<Player> players = new LinkedList<Player>();
	
	public synchronized void addPlayer(Player player){
		players.add(player);
	}
	public synchronized Iterator<Player> getPlayer(){
		return players.iterator();
	}

}
