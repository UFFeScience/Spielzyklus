
import java.util.Set;
import java.util.HashSet;
import java.util.Date;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class gameSession
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE) 
	@javax.persistence.Column(nullable = false) 
	protected Date date;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int level;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected game game1;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "gameSession") 
	protected Set<character_action> character_action;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public gameSession(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetGame1(game myGame1) {
		if (this.game1 != myGame1) {
			if (myGame1 != null){
				if (this.game1 != myGame1) {
					game oldgame1 = this.game1;
					this.game1 = myGame1;
					if (oldgame1 != null)
						oldgame1.removeGameSession1(this);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public game getGame1() {
		return this.game1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<character_action> getCharacter_action() {
		if(this.character_action == null) {
				this.character_action = new HashSet<character_action>();
		}
		return (Set<character_action>) this.character_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllCharacter_action(Set<character_action> newCharacter_action) {
		if (this.character_action == null) {
			this.character_action = new HashSet<character_action>();
		}
		for (character_action tmp : newCharacter_action)
			tmp.setGameSession(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllCharacter_action(Set<character_action> newCharacter_action) {
		if(this.character_action == null) {
			return;
		}
		
		this.character_action.removeAll(newCharacter_action);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setDate(Date myDate) {
		this.date = myDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setLevel(int myLevel) {
		this.level = myLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setGame1(game myGame1) {
		this.basicSetGame1(myGame1);
		myGame1.addGameSession1(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addCharacter_action(character_action newCharacter_action) {
		if(this.character_action == null) {
			this.character_action = new HashSet<character_action>();
		}
		
		if (this.character_action.add(newCharacter_action))
			newCharacter_action.basicSetGameSession(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetDate() {
		this.date = new Date();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetLevel() {
		this.level = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetGame1() {
		if (this.game1 == null)
			return;
		game oldgame1 = this.game1;
		this.game1 = null;
		oldgame1.removeGameSession1(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeCharacter_action(character_action oldCharacter_action) {
		if(this.character_action == null)
			return;
		
		if (this.character_action.remove(oldCharacter_action))
			oldCharacter_action.unsetGameSession();
		
	}

}

