



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class activity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "used") 
	protected entity wasGeneratedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "activity") 
	protected entity entity;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "activity") 
	protected activity wasInformedBy;

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
	public activity(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetWasGeneratedBy(entity myWasGeneratedBy) {
		if (this.wasGeneratedBy != myWasGeneratedBy) {
			if (myWasGeneratedBy != null){
				if (this.wasGeneratedBy != myWasGeneratedBy) {
					entity oldwasGeneratedBy = this.wasGeneratedBy;
					this.wasGeneratedBy = myWasGeneratedBy;
					if (oldwasGeneratedBy != null)
						oldwasGeneratedBy.unsetUsed();
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
						oldentity.unsetActivity();
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
	public void basicSetWasInformedBy(activity myWasInformedBy) {
		if (this.wasInformedBy != myWasInformedBy) {
			if (myWasInformedBy != null){
				if (this.wasInformedBy != myWasInformedBy) {
					activity oldwasInformedBy = this.wasInformedBy;
					this.wasInformedBy = myWasInformedBy;
					if (oldwasInformedBy != null)
						oldwasInformedBy.unsetActivity();
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
						oldactivity.unsetWasInformedBy();
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
						oldagent.unsetWasAssociatedWith();
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
	public entity getWasGeneratedBy() {
		return this.wasGeneratedBy;
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
	public activity getWasInformedBy() {
		return this.wasInformedBy;
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
	public void setWasGeneratedBy(entity myWasGeneratedBy) {
		this.basicSetWasGeneratedBy(myWasGeneratedBy);
		myWasGeneratedBy.basicSetUsed(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setEntity(entity myEntity) {
		this.basicSetEntity(myEntity);
		myEntity.basicSetActivity(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setWasInformedBy(activity myWasInformedBy) {
		this.basicSetWasInformedBy(myWasInformedBy);
		myWasInformedBy.basicSetActivity(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setActivity(activity myActivity) {
		this.basicSetActivity(myActivity);
		myActivity.basicSetWasInformedBy(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setAgent(agent myAgent) {
		this.basicSetAgent(myAgent);
		myAgent.basicSetWasAssociatedWith(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetWasGeneratedBy() {
		if (this.wasGeneratedBy == null)
			return;
		entity oldwasGeneratedBy = this.wasGeneratedBy;
		this.wasGeneratedBy = null;
		oldwasGeneratedBy.unsetUsed();
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
		oldentity.unsetActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetWasInformedBy() {
		if (this.wasInformedBy == null)
			return;
		activity oldwasInformedBy = this.wasInformedBy;
		this.wasInformedBy = null;
		oldwasInformedBy.unsetActivity();
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
		oldactivity.unsetWasInformedBy();
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
		oldagent.unsetWasAssociatedWith();
	}

}

