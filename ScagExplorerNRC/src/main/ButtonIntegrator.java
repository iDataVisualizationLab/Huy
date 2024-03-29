package main;

public class ButtonIntegrator {
	 final float DAMPING = .5f;
	  final float ATTRACTION = 0.3f;

	  float value;
	  float vel;
	  float accel;
	  float force;
	  float mass = 2;

	  float damping = DAMPING;
	  float attraction = ATTRACTION;
	  boolean targeting;
	  float target;


	  ButtonIntegrator() { }


	  ButtonIntegrator(float value) {
	    this.value = value;
	  }


	  ButtonIntegrator(float value, float damping, float attraction) {
	    this.value = value;
	    this.damping = damping;
	    this.attraction = attraction;
	  }


	  void set(float v) {
	    value = v;
	  }


	  void update() {
	    if (targeting) {
	      force += attraction * (target - value);      
	    }

	    accel = force / mass;
	    vel = (vel + accel) * damping;
	    value += vel;

	    force = 0;
	  }


	  void target(float t) {
	    targeting = true;
	    target = t;
	  }


	  void noTarget() {
	    targeting = false;
	  }

}
