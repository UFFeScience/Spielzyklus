
import java.util.Set;
import java.util.HashSet;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class game
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String title;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "game1") 
	protected Set<gameSession> gameSession1;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected platform platform;

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
	public game(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetPlatform(platform myPlatform) {
		if (this.platform != myPlatform) {
			if (myPlatform != null){
				if (this.platform != myPlatform) {
					platform oldplatform = this.platform;
					this.platform = myPlatform;
					if (oldplatform != null)
						oldplatform.removeGame(this);
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
	public String getTitle() {
		return this.title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<gameSession> getGameSession1() {
		if(this.gameSession1 == null) {
				this.gameSession1 = new HashSet<gameSession>();
		}
		return (Set<gameSession>) this.gameSession1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public platform getPlatform() {
		return this.platform;
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
	public void addAllGameSession1(Set<gameSession> newGameSession1) {
		if (this.gameSession1 == null) {
			this.gameSession1 = new HashSet<gameSession>();
		}
		for (gameSession tmp : newGameSession1)
			tmp.setGame1(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllGameSession1(Set<gameSession> newGameSession1) {
		if(this.gameSession1 == null) {
			return;
		}
		
		this.gameSession1.removeAll(newGameSession1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setTitle(String myTitle) {
		this.title = myTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addGameSession1(gameSession newGameSession1) {
		if(this.gameSession1 == null) {
			this.gameSession1 = new HashSet<gameSession>();
		}
		
		if (this.gameSession1.add(newGameSession1))
			newGameSession1.basicSetGame1(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setPlatform(platform myPlatform) {
		this.basicSetPlatform(myPlatform);
		myPlatform.addGame(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetTitle() {
		this.title = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeGameSession1(gameSession oldGameSession1) {
		if(this.gameSession1 == null)
			return;
		
		if (this.gameSession1.remove(oldGameSession1))
			oldGameSession1.unsetGame1();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetPlatform() {
		if (this.platform == null)
			return;
		platform oldplatform = this.platform;
		this.platform = null;
		oldplatform.removeGame(this);
	}

}

