package coda.kiwiboi.common.entities;

import coda.kiwiboi.registry.KBEntities;
import coda.kiwiboi.registry.KBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Kiwi extends Animal implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    private boolean partyKiwi;
    @Nullable
    private BlockPos jukebox;

    public Kiwi(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0F, Kiwi.class));
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0F));
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0F).add(Attributes.MOVEMENT_SPEED, 0.25F);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return KBEntities.KIWI.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(KBItems.KIWICAKE.get());
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        return super.mobInteract(pPlayer, pHand);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PARROT_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PARROT_HURT;
    }

    public void setRecordPlayingNearby(BlockPos pPos, boolean pIsPartying) {
        this.jukebox = pPos;
        this.partyKiwi = pIsPartying;
    }

    public boolean isPartyKiwi() {
        return this.partyKiwi;
    }

    public void aiStep() {
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 3.46D) || !this.level.getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            this.partyKiwi = false;
            this.jukebox = null;
        }

        super.aiStep();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 2F, this::predicate));
    }

    private PlayState predicate(AnimationEvent<?> e) {
        if (isPartyKiwi() && !e.isMoving()) {
            e.getController().setAnimation(new AnimationBuilder().addAnimation("kiwi.dance", true));
        }
        else if (e.isMoving()) {
            e.getController().setAnimation(new AnimationBuilder().addAnimation("kiwi.walk", true));
        }
        else {
            e.getController().setAnimation(new AnimationBuilder().addAnimation("kiwi.idle", true));
        }

        e.getController().setAnimationSpeed(2.0D);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
