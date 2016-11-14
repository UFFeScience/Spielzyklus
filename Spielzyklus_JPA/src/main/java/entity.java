



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class entity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "entity") 
	protected entity wasDerivedFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected entity entity;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected activity used;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected activity activity;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected agent agent;

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
	public entity(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetWasDerivedFrom(entity myWasDerivedFrom) {
		if (this.wasDerivedFrom != myWasDerivedFrom) {
			if (myWasDerivedFrom != null){
				if (this.wasDerivedFrom != myWasDerivedFrom) {
					entity oldwasDerivedFrom = this.wasDerivedFrom;
					this.wasDerivedFrom = myWasDerivedFrom;
					if (oldwasDerivedFrom != null)
						oldwasDerivedFrom.unsetEntity();
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
	public void basicSetEntity(entity myEntity) {
		if (this.entity != myEntity) {
			if (myEntity != null){
				if (this.entity != myEntity) {
					entity oldentity = this.entity;
					this.entity = myEntity;
					if (oldentity != null)
						oldentity.unsetWasDerivedFrom();
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
	public void basicSetUsed(activity myUsed) {
		if (this.used != myUsed) {
			if (myUsed != null){
				if (this.used != myUsed) {
					activity oldused = this.used;
					this.used = myUsed;
					if (oldused != null)
						oldused.unsetWasGeneratedBy();
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
	public void basicSetActivity(activity myActivity) {
		if (this.activity != myActivity) {
			if (myActivity != null){
				if (this.activity != myActivity) {
					activity oldactivity = this.activity;
					this.activity = myActivity;
					if (oldactivity != null)
						oldactivity.unsetEntity();
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
	public void basicSetAgent(agent myAgent) {
		if (this.agent != myAgent) {
			if (myAgent != null){
				if (this.agent != myAgent) {
					agent oldagent = this.agent;
					this.agent = myAgent;
					if (oldagent != null)
						oldagent.unsetWasAttributedTo();
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
	public entity getWasDerivedFrom() {
		return this.wasDerivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public entity getEntity() {
		return this.entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public activity getUsed() {
		return this.used;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public activity getActivity() {
		return this.activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public agent getAgent() {
		return this.agent;
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
	public void setWasDerivedFrom(entity myWasDerivedFrom) {
		this.basicSetWasDerivedFrom(myWasDerivedFrom);
		myWasDerivedFrom.basicSetEntity(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setEntity(entity myEntity) {
		this.basicSetEntity(myEntity);
		myEntity.basicSetWasDerivedFrom(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setUsed(activity myUsed) {
		this.basicSetUsed(myUsed);
		myUsed.basicSetWasGeneratedBy(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setActivity(activity myActivity) {
		this.basicSetActivity(myActivity);
		myActivity.basicSetEntity(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setAgent(agent myAgent) {
		this.basicSetAgent(myAgent);
		myAgent.basicSetWasAttributedTo(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetWasDerivedFrom() {
		if (this.wasDerivedFrom == null)
			return;
		entity oldwasDerivedFrom = this.wasDerivedFrom;
		this.wasDerivedFrom = null;
		oldwasDerivedFrom.unsetEntity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetEntity() {
		if (this.entity == null)
			return;
		entity oldentity = this.entity;
		this.entity = null;
		oldentity.unsetWasDerivedFrom();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetUsed() {
		if (this.used == null)
			return;
		activity oldused = this.used;
		this.used = null;
		oldused.unsetWasGeneratedBy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetActivity() {
		if (this.activity == null)
			return;
		activity oldactivity = this.activity;
		this.activity = null;
		oldactivity.unsetEntity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetAgent() {
		if (this.agent == null)
			return;
		agent oldagent = this.agent;
		this.agent = null;
		oldagent.unsetWasAttributedTo();
	}

}

