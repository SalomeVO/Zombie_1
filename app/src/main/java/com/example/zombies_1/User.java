package com.example.zombies_1;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable; // Agrega la importación de Parcelable

public class User implements Serializable, Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("points")
    private int points;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("dateZ")
    private String dateZ;

    @SerializedName("image")
    private String image;

    // Constructor
    public User(int id, String name, int points, String email, String password, String dateZ, String image) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.email = email;
        this.password = password;
        this.dateZ = dateZ;
        this.image = image;
    }

    // Implementación de Parcelable
    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        points = in.readInt();
        email = in.readString();
        password = in.readString();
        dateZ = in.readString();
        image = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(points);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(dateZ);
        dest.writeString(image);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationDate() {
        return dateZ;
    }

    public int getId() {
        return id;
    }
}
