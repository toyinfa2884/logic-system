package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository{
    private  final Map<Integer,Package> database = new HashMap<>();
    @Override
    public Package save(Package aPackage) {
        Integer id = null;
        if(aPackage.getId() == null) {
            id = database.size() + 1;//give me the size and add 1 into it
            aPackage.setId(id);
        }
        id = aPackage.getId();
        database.put(id, aPackage);
        return database.get(id);
    }

    @Override
    public List<Package> findAll() {
        List<Package> packages = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for(Integer key : keys){
            packages.add(database.get(key));
        }
//        keys.forEach(key ->all.add(database.get(key))); //the same as line 25 and 26.
        return packages;
    }

    @Override
    public void delete(Package aPackage) {
        database.remove(aPackage.getId());

    }

    @Override
    public void deleteById(Integer id) {
        database.remove(id);

    }

    @Override
    public Package findById(Integer id) {
        return database.get(id);
    }
}
