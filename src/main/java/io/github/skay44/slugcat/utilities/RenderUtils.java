package io.github.skay44.slugcat.utilities;

import net.minecraft.util.math.Vec3d;
import org.joml.Vector4d;

import java.lang.Math.*;

public class RenderUtils {
    static Vector4d V3toV4(Vec3d vec, float angle){
        Vector4d result = new Vector4d(1,0,0,0);
        result.x = vec.x * Math.sin(angle/2);
        result.y = 0;
        result.z = vec.z * Math.sin(angle/2);
        result.w = Math.cos(angle/2);
        //result.normalize();
        return result;
    }

    static Vec3d rotate(Vec3d point,Vector4d quat){
        float a1 = (float)quat.w;
        float b1 = (float)quat.x;
        float c1 = (float)quat.y;
        float d1 = (float)quat.z;

        float b2 = (float)point.x*100;
        float c2 = (float)point.y*100;
        float d2 = (float)point.z*100;

        Vec3d r = new Vec3d(
                (a1*b2*a1-a1*c2*d1+a1*d2*c1+b1*b2*b1+b1*c2*c1+b1*d2*d1-d1*b2*d1-d1*c2*a1+d1*d2*b1) /100,
                (a1*b2*d1+a1*c2*a1-a1*d2*b1+b1*b2*c1-b1*c2*b1-b1*d2*a1+d1*b2*a1-d1*c2*d1+d1*d2*c1) /100,
                (a1*b2*c1+a1*c2*b1+a1*d2*a1+b1*b2*d1+b1*c2*a1-b1*d2*b1+d1*b2*b1+d1*c2*c1+d1*d2*d1) /100
        );
        return r;
    }

//    public static Vec3d rotateTowardsVector(Vec3d vector,float pitch, Vec3d point){
//        Vec3d perpendicularVector = new Vec3d(-vector.z,0,vector.x);
//        perpendicularVector.normalize();
//        float rotation = (float)(-Math.acos(pitch));
//
//        Vector4d rotationQuat = V3toV4(perpendicularVector,rotation);
//
//
//        return rotate(point,rotationQuat);
//    }

    public static Vec3d rotateTowardsVector(Vec3d vector, Vec3d point){
        Vec3d perpendicularVector = new Vec3d(-vector.z,0,vector.x);
        perpendicularVector = perpendicularVector.normalize();
        float rotation = (float)(-Math.acos((vector.normalize()).y));

        Vector4d rotationQuat = V3toV4(perpendicularVector,rotation);


        return rotate(point,rotationQuat);
    }
}
