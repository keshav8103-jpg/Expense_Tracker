    package com.example.exp_backend.Service;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.example.exp_backend.Model.BudgetModel;
import com.example.exp_backend.Model.UserModel;
import com.example.exp_backend.Repo.BudgetRepo;
    import com.example.exp_backend.Repo.UserRepo;

    @Service
    public class BudgetService 
    {

        @Autowired 
        private BudgetRepo budgetRepo;

        @Autowired
        private UserRepo userRepo;


        //add Budget-----
        public BudgetModel addBudget(BudgetModel budget)
        {
            if(budget.getUser()==null)
            {
                return null;
            }

            Long userId=budget.getUser().getUserId();
            UserModel user=userRepo.findById(userId).orElse(null);

            if(user==null)
            {
                return null;
            }   
            
            budget.setUser(user);
            return budgetRepo.save(budget);
        }

        //get all Budget-----
        public List<BudgetModel> getAllBudget()
        {
            return budgetRepo.findAll();
        }

        // get budget by id-----
        public BudgetModel getBudgetById(Long id)
        {
            return budgetRepo.findById(id).orElse(null);
        }

        //update budget----
        public BudgetModel updateBudget(BudgetModel updateBudget, Long id)
        {
            BudgetModel budget=budgetRepo.findById(id).orElse(null);

            if(budget!=null)
            {
                budget.setName(updateBudget.getName());
                budget.setAmount(updateBudget.getAmount());
                budget.setPeriod(updateBudget.getPeriod());
                budget.setStartDate(updateBudget.getStartDate());

                return budgetRepo.save(budget);
            }
            return null;
        }

        //delete budget-----
        public String deleteBudget(Long id)
        {
            BudgetModel budget=budgetRepo.findById(id).orElse(null);

            if(budget!=null)
            {
                budgetRepo.deleteById(id);
                return "Budget deleted Successfully";
            }
            return "Budget not Found";
        }
        
    }
