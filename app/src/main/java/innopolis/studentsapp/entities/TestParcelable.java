package innopolis.studentsapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by davlet on 6/27/17.
 */

public class TestParcelable implements Parcelable {
    public String name;
    public Integer id;

    public TestParcelable(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public TestParcelable(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<TestParcelable> CREATOR = new Creator<TestParcelable>() {
        @Override
        public TestParcelable createFromParcel(Parcel in) {
            return new TestParcelable(in);
        }

        @Override
        public TestParcelable[] newArray(int size) {
            return new TestParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }
}
